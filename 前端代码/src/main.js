import Vue from 'vue'
import App from './App.vue'
//  引入路由
import router from './router'
//  引入状态管理
import store from './store'
//  引入ElementUI
import './plugin'
//  引入全局样式
import './style/global.less'

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
