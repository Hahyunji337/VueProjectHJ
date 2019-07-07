<template>
<div>
    <Header></Header>
    <div class="wrapper">
        <div class="profile-content section-nude">
            <div class="profile-background"> 
            <div class="filter-black"></div>  
            </div>
            <div class="container">
                <div class="row owner">
                    <div class="col-md-2 col-md-offset-5 col-sm-4 col-sm-offset-4 col-xs-6 col-xs-offset-3 text-center">
                        <div class="avatar">
                            <img src="/static/paper_img/logo.jpg" alt="Circle Image" class="img-circle img-no-padding img-responsive">
                        </div>
                        <div class="name"> 
                            <h4>{{this.$store.state.name}}<br /><small>{{this.$store.state.email}}</small></h4>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 col-md-offset-3 text-center">
                        <p>{{this.$store.state.introduce}} </p>
                        <br />
                        <btn class="btn" @click="profileModBtn">프로필 수정</btn>
                        <btn class="btn" @click="pwModBtn">비밀번호 수정</btn>
                        <btn class="btn" @click="memberList">회원관리</btn> 
                        <btn class="btn btn-fill" @click="remove">회원탈퇴</btn> 
                    </div>
                </div>          
            </div>
        </div> 
    </div>
    <Footer></Footer>
 </div>      
</template>

<script>
import Header from '@/components/common/Header.vue'
import Footer from'@/components/common/Footer.vue'
import axios from 'axios'
import {store} from '../../store'
export default {
data(){
    return {
        context  : 'http://localhost:9000/members'          
        }
},
created(){
    //로그인 안했으면 접근불가
    if (store.state.email == '') {
      this.$router.push('/');
    }
}, 
 components:{
    Header,
    Footer
  },
  methods: {
       profileModBtn(){
           this.$router.push('/mypageUpdate')
       } ,
       pwModBtn(){
           this.$router.push('/myinfoUpdate')
       },
       memberList(){
           this.$router.push('/memberList')
       },
       masteryn(){
           if (store.state.grade=='3') {
                return  false
            }else{
                return true
            }
       },
       remove(){
           if (confirm("정말로 탈퇴하시겠습니까?")) {
                axios.delete(`${this.context}/${store.state.id}`)
                .then(res=>{
                    alert(`${res.data.result}`);
                    //스토어에서 값 삭제
                    store.state.name      = "";
                    store.state.email     = "";
                    store.state.password  = "";
                    store.state.introduce = "";
                    store.state.grade     = "";
                    store.state.id        = "";
                    //메인페이지로 이동
                    this.$router.push('/');
                })
                .catch(e=>{
                    alert('ERROR');
                    this.$router.link(-1);
                })
            }    
       }
  }
}
</script>

<style scoped>
</style>