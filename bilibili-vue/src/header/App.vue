<template>
  <div id="app">
    <Header></Header>
  </div>
</template>

<script>
import Header from './views/Header'
export default {
  name: 'App',
  components: {Header}
}
</script>

<style lang="scss">
html, body {
  margin: 0;
  padding: 0;
  height: 100%;
}

#app {
  height: 100%;
  display: flex;
}
</style>
