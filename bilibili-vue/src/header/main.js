import Vue from 'vue'
import router from './router'
import store from './store'
import App from './App'

import utils from '../comm/script/utils/index'

Vue.prototype.$utils = utils
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#header',
  store,
  router,
  template: '<App/>',
  components: {App}
})
