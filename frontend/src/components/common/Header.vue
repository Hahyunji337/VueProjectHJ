<template>
   <div>
    <nav class="navbar navbar-ct-transparent navbar-fixed-top" role="navigation-demo" id="register-navbar">
      <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <a class="navbar-brand" @click="logo" style="cursor:pointer">Trip MoA</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <ul class="nav navbar-nav navbar-right">
          <li v-if="!loginYn()">
              <a class="btn btn-danger" @click="loginBtn">로그인</a>
          </li>
          <li v-if="!loginYn()">
              <a class="btn btn-danger btn-fill" @click="JoinBtn">회원가입</a>
          </li>
          <li v-if="loginYn()">
              <a style="cursor:pointer" @click="mypage" id="welcomeMent"><span id="loginNm">{{this.$store.state.name}}</span> 님 환영합니다.</a>
          </li>
          <li v-if="loginYn()">
              <a class="btn btn-danger btn-fill" @click="logOutBtn">로그아웃</a>
          </li>
          </ul>
      </div><!-- /.container-->
    </nav> 
</div> 
   
</template>
<script>
import {store} from '../../store'

export default {

  data () {
    return {
    }
  },
  methods: {
    logo(){
      this.$router.push('/');
    },
    mypage(){
      this.$router.push('/mypage');
    },
    loginBtn(){
      this.$router.push('/loginForm');
    },
    JoinBtn(){
      this.$router.push('/joinForm');
    },
    logOutBtn(){
      //스토어 비우기
      store.state.name      = '';
      store.state.email     = '';
      store.state.password  = '';
      store.state.introduce = '';
      store.state.grade     = '';
      store.state.id        = '';
      alert('로그아웃 되었습니다.');
      //메인페이지로 이동
      this.$router.push('/');
    },
    loginYn(){
      //로그인 여부
      return (store.state.email=='')? false : true;
    }
  }
}
</script>
<style scoped>
#welcomeMent{
  color     :white;
  text-shadow: 0 0 2px black;
}
 #loginNm{
   font-size : 1.2em;
   color     :orange;
 }
</style>