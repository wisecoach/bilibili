<template>
  <div>
    <div id="app">
      <div>{{$store.state}}</div>
      <Login/>
    </div>
  </div>
</template>

<script>
import Login from './views/Login'

export default {
  name: 'App',
  components: {Login}
}
</script>

<style lang="scss">
html, body {
  margin: 0;
  padding: 0;
  height: 100%;
}

</style>
