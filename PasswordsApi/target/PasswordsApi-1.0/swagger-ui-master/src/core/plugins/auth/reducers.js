import { fromJS, Map } from "immutable"
import btoa from "btoa"

import {
  SHOW_AUTH_POPUP,
  AUTHORIZE,
  AUTHORIZE_OAUTH2,
  LOGOUT
} from "./actions"

export default {
  [SHOW_AUTH_POPUP]: (state, { payload } ) =>{
    return state.set( "showDefinitions", payload )
  },

  [AUTHORIZE]: (state, { payload } ) =>{
    let securities = fromJS(payload)
    let map = state.get("authorized") || Map()

    // refactor withMutations
    securities.entrySeq().forEach( ([ key, security ]) => {
      let type = security.getIn(["schema", "type"])

      if ( type === "apiKey" ) {
        map = map.set(key, security)
      } else if ( type === "basic" ) {
        let username = security.getIn(["value", "username"])
        let password = security.getIn(["value", "password"])

        map = map.setIn([key, "value"], {
          username: username,
          header: "Basic " + btoa(username + ":" + password)
        })

        map = map.setIn([key, "schema"], security.get("schema"))
      }
    })

    return state.set( "authorized", map )
  },

  [AUTHORIZE_OAUTH2]: (state, { payload } ) =>{
    let { auth, token } = payload
    let parsedAuth

    auth.token = token
    parsedAuth = fromJS(auth)

    return state.setIn( [ "authorized", parsedAuth.get("name") ], parsedAuth )
  },

  [LOGOUT]: (state, { payload } ) =>{
    let result = state.get("authorized").withMutations((authorized) => {
        payload.forEach((auth) => {
          authorized.delete(auth)
        })
      })

    return state.set("authorized", result)
  }
}
