module.exports = {
  devServer: {
    host: 'localhost',
    port: 1001,
    hotOnly: true,
    //  代理服务器
    proxy: {
      '/': {
        target: 'http://localhost:2001',
        ws: false,
        changeOrigin: true,
        pathReWrite: {
          '^/': '/'
        }
      }
    }
  }
}
