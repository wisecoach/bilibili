<template>
  <div class='login'>
    <div class='login-form'>
      <el-form :model='form'>
        <el-form-item label=''>
          <el-input v-model='form.mid' placeholder='请输入账号或手机号码或邮箱'></el-input>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>
<script>
export default {
  name: 'Login',
  data () {
    return {
      form: {
        mid: '',
        password: ''
      }
    }
  }
}
</script>

<style scoped lang='scss'>

.login {
  background: aquamarine;
  width: 100%;
  height: 1000px;

  .login-form{
    background: darkkhaki;
    width: 600px;
    height: 400px;
    margin: auto 100px 0;
  }
}

</style>
