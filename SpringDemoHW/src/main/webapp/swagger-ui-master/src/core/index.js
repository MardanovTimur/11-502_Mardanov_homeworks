import deepExtend from "deep-extend"

import System from "core/system"
import ApisPreset from "core/presets/apis"
import * as AllPlugins from "core/plugins/all"
import { filterConfigs } from "plugins/configs"
import { parseSeach } from "core/utils"

module.exports = function SwaggerUI(opts) {

  const defaults = {
    // Some general settings, that we floated to the top
    dom_id: null,
    spec: {},
    url: "",
    layout: "Layout",
    validatorUrl: "https://online.swagger.io/validator",
    configs: {
    },

    // Initial set of plugins ( TODO rename this, or refactor - we don't need presets _and_ plugins. Its just there for performance.
    // Instead, we can compile the first plugin ( it can be a collection of plugins ), then batch the rest.
    presets: [
    ],

    // Plugins; ( loaded after presets )
    plugins: [
    ],

    // Inline Plugin
    fn: { },
    components: { },
    state: { },

    // Override some core configs... at your own risk
    store: { },
  }

  const constructorConfig = deepExtend({}, defaults, opts)

  const storeConfigs = deepExtend({}, constructorConfig.store, {
    system: {
      configs: constructorConfig.configs
    },
    plugins: constructorConfig.presets,
    state: {
      layout: {
        layout: constructorConfig.layout
      },
      spec: {
        spec: "",
        url: constructorConfig.url
      }
    }
  })

  let inlinePlugin = ()=> {
    return {
      fn: constructorConfig.fn,
      components: constructorConfig.components,
      state: constructorConfig.state,
    }
  }

  var store = new System(storeConfigs)
  store.register([constructorConfig.plugins, inlinePlugin])

  var system = store.getSystem()
  let queryConfig = parseSeach()

  const downloadSpec = () => {
    if(typeof constructorConfig !== "object") {
      return system
    }

    let localConfig = system.specSelectors.getLocalConfig ? system.specSelectors.getLocalConfig() : {}
    let mergedConfig = deepExtend({}, constructorConfig, localConfig, queryConfig)
    store.setConfigs(filterConfigs(mergedConfig))

    if(!queryConfig.url && typeof mergedConfig.spec === "object" && Object.keys(mergedConfig.spec).length) {
      system.specActions.updateUrl("")
      system.specActions.updateLoadingStatus("success")
      system.specActions.updateSpec(JSON.stringify(mergedConfig.spec))
    } else if(system.specActions.download && mergedConfig.url) {
      system.specActions.updateUrl(mergedConfig.url)
      system.specActions.download(mergedConfig.url)
    }

    if(mergedConfig.dom_id) {
      system.render(mergedConfig.dom_id, "App")
    } else {
      console.error("Skipped rendering: no `dom_id` was specified")
    }

    return system
  }

  if (!system.specActions.getConfigByUrl || (system.specActions.getConfigByUrl && !system.specActions.getConfigByUrl(downloadSpec))) {
    return downloadSpec()
  }

}

// Add presets
module.exports.presets = {
  apis: ApisPreset,
}

// All Plugins
module.exports.plugins = AllPlugins
