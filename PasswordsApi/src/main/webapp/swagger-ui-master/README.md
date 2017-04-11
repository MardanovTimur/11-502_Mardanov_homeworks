# Swagger UI

[![NPM version](https://badge.fury.io/js/swagger-ui.svg)](http://badge.fury.io/js/swagger-ui)

## New!

**This is the new version of swagger-ui, 3.x. Want to learn more? Check out our [FAQ](http://swagger.io/new-ui-faq/).**

As a brand new version, written from the ground up, there are some known issues and unimplemented features. Check out the [Known Issues](#known-issues) section for more details.

For the older version of swagger-ui, refer to the [*2.x branch*](https://github.com/swagger-api/swagger-ui/tree/2.x).

## Compatibility
The OpenAPI Specification has undergone 4 revisions since initial creation in 2010.  Compatibility between swagger-ui and the OpenAPI Specification is as follows:

Swagger UI Version | Release Date | OpenAPI Spec compatibility | Notes | Status
------------------ | ------------ | -------------------------- | ----- | ------
3.0.3              | 2017-03-19   | 2.0                        | [tag v3.0.3](https://github.com/swagger-api/swagger-ui/tree/v3.0.3) |
2.2.10             | 2017-01-04   | 1.1, 1.2, 2.0              | [tag v2.2.10](https://github.com/swagger-api/swagger-ui/tree/v2.2.10) |
2.1.5              | 2016-07-20   | 1.1, 1.2, 2.0              | [tag v2.1.5](https://github.com/swagger-api/swagger-ui/tree/v2.1.5) |
2.0.24             | 2014-09-12   | 1.1, 1.2 | [tag v2.0.24](https://github.com/swagger-api/swagger-ui/tree/v2.0.24) |
1.0.13             | 2013-03-08   | 1.1, 1.2 | [tag v1.0.13](https://github.com/swagger-api/swagger-ui/tree/v1.0.13) |
1.0.1              | 2011-10-11   | 1.0, 1.1 | [tag v1.0.1](https://github.com/swagger-api/swagger-ui/tree/v1.0.1)   |


### How to run

##### Easy start!  Docker
You can pull a pre-built docker image of the swagger-ui directly from Dockerhub:

```
docker pull swaggerapi/swagger-ui
docker run -p 80:8080 swaggerapi/swagger-ui
```

Will start nginx with swagger-ui on port 80.

##### Prerequisites
- Node 6.x
- NPM 3.x

If you just want to see your specs, open `public/index.html` in your browser directly from your filesystem.

If you'd like to make modifications to the codebase, run the dev server with: `npm run dev`.

##### Browser support
Swagger UI works in the latest versions of Chrome, Safari, Firefox, Edge and IE11.

### Known Issues

To help with the migration, here are the currently known issues with 3.X. This list will update regularly, and will not include features that were not implemented in previous versions.

- Currently, the only configuration options available are the `url` and `spec`.
- The JSON Form Editor is not implemented.
- Shebang URL support for operations is missing.
- Support for `collectionFormat` is partial.
- l10n (translations) is not implemented.
- Relative path support for external files is not implemented.


## CORS Support

CORS is a technique to prevent websites from doing bad things with your personal data.  Most browsers + JavaScript toolkits not only support CORS but enforce it, which has implications for your API server which supports Swagger.

You can read about CORS here: http://www.w3.org/TR/cors.

There are two cases where no action is needed for CORS support:

1. swagger-ui is hosted on the same server as the application itself (same host *and* port).
2. The application is located behind a proxy that enables the required CORS headers. This may already be covered within your organization.

Otherwise, CORS support needs to be enabled for:

1. Your Swagger docs. For Swagger 2.0 it's the `swagger.json`/`swagger.yaml` and any externally `$ref`ed docs.
2. For the `Try it now` button to work, CORS needs to be enabled on your API endpoints as well.

### Testing CORS Support

You can verify CORS support with one of three techniques:

- Curl your API and inspect the headers.  For instance:

```bash
$ curl -I "http://petstore.swagger.io/v2/swagger.json"
HTTP/1.1 200 OK
Date: Sat, 31 Jan 2015 23:05:44 GMT
Access-Control-Allow-Origin: *
Access-Control-Allow-Methods: GET, POST, DELETE, PUT, PATCH, OPTIONS
Access-Control-Allow-Headers: Content-Type, api_key, Authorization
Content-Type: application/json
Content-Length: 0
```

This tells us that the petstore resource listing supports OPTIONS, and the following headers:  `Content-Type`, `api_key`, `Authorization`.

- Try swagger-ui from your file system and look at the debug console.  If CORS is not enabled, you'll see something like this:

```
XMLHttpRequest cannot load http://sad.server.com/v2/api-docs. No 'Access-Control-Allow-Origin' header is present on the requested resource. Origin 'null' is therefore not allowed access.
```

Swagger-UI cannot easily show this error state.

- Using the http://www.test-cors.org website. Keep in mind this will show a successful result even if `Access-Control-Allow-Headers` is not available, which is still required for Swagger-UI to function properly.

### Enabling CORS

The method of enabling CORS depends on the server and/or framework you use to host your application. http://enable-cors.org provides information on how to enable CORS in some common web servers.

Other servers/frameworks may provide you information on how to enable it specifically in their use case.

### CORS and Header Parameters

Swagger lets you easily send headers as parameters to requests.  The name of these headers *MUST* be supported in your CORS configuration as well.  From our example above:

```
Access-Control-Allow-Headers: Content-Type, api_key, Authorization
```

Only headers with these names will be allowed to be sent by Swagger-UI.

## License

Copyright 2017 SmartBear Software

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at [apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
