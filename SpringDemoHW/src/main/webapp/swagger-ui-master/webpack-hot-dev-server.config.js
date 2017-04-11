var path = require('path')

module.exports = require("./make-webpack-config")({
  _special: {
    loaders: {
      'jsx': [ "react-hot-loader", "babel" ]
    },
    separateStylesheets: false,
  },
	devtool: "eval",
  entry: {
    'SwaggerUIBundle': [
      'babel-polyfill',
      './src/core/index.js'
    ],
    'SwaggerUIStandalonePreset': [
      './src/standalone/index.js'
    ]
  },
  output: {
    pathinfo: true,
    debug: true,
    filename: '[name].js',
    library: "[name]",
    libraryTarget: "umd",
    chunkFilename: "[id].js"
  },
  devServer: {
    port: 3200,
    path: path.join(__dirname, 'dist'),
    publicPath: "/dist",
    noInfo: true,
    colors: true,
    hot: true,
    stats: {
      colors: true
    },
  },
})
