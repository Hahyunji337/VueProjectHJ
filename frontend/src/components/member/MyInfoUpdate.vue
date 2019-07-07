<template>
    <div class="wrapper">
        <div class="filter-black"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1 ">
                    <div class="register-card">
                        <h3 class="title">비밀번호 수정</h3>
                        <form class="register-form">       
                            <input type="password" class="form-control" placeholder="현재 비밀번호" @keypress="nowPwch" v-model="nowpw"><span id="correct" v-if="nowPwch()">비밀번호 일치</span><span id="notCorrect" v-if="!nowPwch()">비밀번호 불일치</span>
                            <br><br>
                            <input type="password" class="form-control" placeholder="새로운 비밀번호" v-model="newpw">
                            <br>
                            <input type="password" class="form-control" placeholder="새로운 비밀번호 확인" v-model="newpwck" @keypress="newPwch"><span id="notCorrect" v-if="!newPwch()">입력하신 비밀번호와 새 비밀번호가 일치하지 않습니다.</span>
                            <button class="btn btn-danger btn-block" @click="updatePw()">비밀번호 수정</button>
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
created(){
    //로그인 안했으면 접근불가
    if (store.state.email == '') {
      this.$router.push('/');
    }
},    
data(){
    return {
        context  :'http://localhost:9000/members',
        nowpw    : '',
        newpw    : '',
        newpwck  : ''
    }
  },
 methods: {
       updatePw(){
           //폼태그라서 자꾸 새로고침됨 수정
           event.preventDefault();
           //조건일치시만 비밀번호 변경 실행
           if((store.state.password==this.nowpw&&store.state.password!='')&&(this.newpw==this.newpwck && this.newpwck!='')){
               let data = {
                    name      : this.$store.state.name,
                    introduce : this.$store.state.introduce,
                    id        : this.$store.state.id,
                    email     : this.$store.state.email,
                    grade     : this.$store.state.grade,
                    password  : this.newpwck
                }
                let headers = {
                    'Content-Type'  : 'application/json',
                    'Authorization' : 'JWT fefege..'
                }
                //비밀번호 변경
                axios.post(`${this.context}/updateMypage`, JSON.stringify(data),
                        {headers : headers})
                .then(res=>{
                    alert(`SUCESS2:${res.data.result}`);
                    //로그아웃(세션삭제)
                    store.state.name      = '';
                    store.state.email     = '';
                    store.state.password  = '';
                    store.state.introduce = '';
                    store.state.grade     = '';
                    store.state.id        = '';
                    alert('비밀번호가 변경되었습니다. 다시 로그인해주세요.');
                    this.$router.push('/');
                })
                .catch(e=>{
                    alert('ERROR');
                    this.$router.link(-1);
                })
           }else{
               alert("비밀번호를 다시 체크해주세요");
           }
       },
       //비밀번호 체크
       nowPwch(){
            if (store.state.password == this.nowpw&&store.state.password != '') {
                return true
            }else{
                return false
            }
       },
       //새 비밀번호 체크
       newPwch(){
            if (this.newpw == this.newpwck && this.newpwck != '') {
                return true
            }else{
                return false
            }
       }
  }
}
</script>

<style scoped>
    #notCorrect{
        color : red
    }
    #correct{
        color : blue
    }
</style>