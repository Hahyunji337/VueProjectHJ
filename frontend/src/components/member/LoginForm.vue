<template>
    <div class="wrapper"> 
        <div class="filter-black"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1 ">
                    <div class="register-card">
                        <h3 class="title">Login</h3>
                        <form class="register-form">
                            <input type="text" class="form-control" placeholder="Email" v-model="email">
                            <br>
                            <input type="password" class="form-control" placeholder="Password" v-model="password">
                            <button class="btn btn-danger btn-block" @click="loginConfirm">로그인</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>     
    </div>
  
</template>

<script>

import axios from 'axios'
import {store} from '../../store'
export default {

 data(){
        return {
            context  :'http://localhost:9000/members',
            email    : '',
            password : ''
        } 
  },
  methods: {
       loginConfirm(){
           event.preventDefault();
           let data = {
                email    : this.email,
                password : this.password
            }
            let headers = {
                'Content-Type'  : 'application/json',
                'Authorization' : 'JWT fefege..'
            }
            axios.post(`${this.context}/login`,JSON.stringify(data),{headers : headers}) 
                    .then(res=>{
                        alert(`login() SUCESS : ${res.data.name} 님 환영합니다.`);
                        //스토어에 저장
                        store.state.name      = res.data.name;
                        store.state.email     = res.data.email;
                        store.state.password  = res.data.password;
                        store.state.introduce = res.data.introduce;
                        store.state.grade     = res.data.grade;
                        store.state.id        = res.data.id;
                        //마이페이지로 이동
                        this.$router.push('/mypage');
                    })
                    .catch(e=>{
                        alert('아이디와 비밀번호가 일치하지 않습니다.');
                        this.$router.link(-1);
                    })    
       }
  }
}
</script>

<style scoped>

</style>
