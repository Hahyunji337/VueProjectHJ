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
                           <input class="form-control" v-model="name" id="name">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 col-md-offset-3 text-center">
                        <br>
                        <textarea class="form-control" rows="4" v-model="introduce" id="introduce">
                        </textarea>
                        <br>
                        <btn class="btn" @click="update">수정</btn>
                        <btn class="btn" @click="cancle">취소</btn>
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
import {store} from '../../store'
import axios from 'axios'

export default {
data(){
    return {
        context   :'http://localhost:9000/members',
        name      : this.$store.state.name,
        introduce : this.$store.state.introduce
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
       cancle(){
           this.$router.push('/mypage')
       },
       update(){
            let data = {
                name      : this.name,
                introduce : this.introduce,
                id        : this.$store.state.id,
                email     : this.$store.state.email,
                grade     : this.$store.state.grade,
                password  : this.$store.state.password
            }
            let headers = {
                'Content-Type'  : 'application/json',
                'Authorization' : 'JWT fefege..'
            }
            axios.post(`${this.context}/updateMypage`, JSON.stringify(data),
                    {headers : headers})
            .then(res=>{
                alert(`SUCESS2:${res.data.result}`);
                //바뀐 값을 스토어에 저장
                store.state.name      = this.name;
                store.state.introduce = this.introduce;
                this.$router.push('/mypage');
            })
            .catch(e=>{
                this.$router.link(-1);
            })
       }
  }
}
</script>

<style scoped>
#name,#introduce{
    background-color : #FFFFFF;
}
</style>