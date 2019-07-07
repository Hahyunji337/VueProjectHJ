<template>
    <div class="wrapper">
        <div class="filter-black"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1 ">
                    <div class="register-card">
                        <h3 class="title">Join</h3>
                        <form class="register-form" @submit.prevent="joinConfirm">
                            <input type="email" class="form-control" placeholder="Email" v-model="email">
                            <br>
                            <input type="text" class="form-control" placeholder="name" v-model="name">
                            <br>
                            <input type="password" class="form-control" placeholder="Password" v-model="password">
                            <button class="btn btn-danger btn-block">회원가입</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>     
    </div>      
</template>

<script>
import axios from 'axios'

export default {
    data(){
        return {
            context  :'http://localhost:9000/members',
            name     : '',
            email    : '',
            password : '',
            grade    : ''
        }
    },
    methods: {
        joinConfirm(){
            let data = {
                name     : this.name,
                email    : this.email,
                password : this.password,
                grade    : 2 
            }
            let headers = {
                'Content-Type'  : 'application/json',
                'Authorization' : 'JWT fefege..'
            }
            axios.post(`${this.context}`, JSON.stringify(data),
                    {headers : headers})
            .then(res=>{
                alert(`${res.data.result}`);
                this.$router.push('/');
            })
            .catch(e=>{
                alert('ERROR');
                this.$router.link(-1);
            }) 
       } 
  }
}
</script>

<style scoped>
</style>