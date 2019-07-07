<template>
<div>
  <Header></Header>
  <h4>회원관리</h4>
    <table class="w3-table w3-bordered w3-striped w3-border test w3-hoverable">
      <tbody>
        <tr class="orange">
            <th>이메일</th>
            <th>이름</th>
            <th>상태</th>
        </tr>
      </tbody>
      <tbody>
      <tr v-for="item in arr" :key="item">
        <td>{{item.email}}</td>
        <td>{{item.name}}</td>
        <!-- 자기자신 강퇴불가 -->
        <td><button @click="remove(item.id)" v-if="item.email!=$store.state.email">강퇴</button></td>
      </tr>  
      </tbody>
    </table>
    <br>
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
            context  :'http://localhost:9000/members',
            arr: []
        }
  },
  created(){
    //로그인 안했으면 접근불가
    if (store.state.email == '') {
      this.$router.push('/');
    }
    axios.get(`${this.context}/memberList`)
         .then(res=>{
             this.arr = res.data
         })
         .catch(e=>{
             alert('ERROR');
             this.$router.link(-1);
         })
  },
  components:{
    Header,
    Footer
  },
  methods:{
    remove(x){
      if (confirm("정말로 탈퇴시키겠습니까?")) {
        axios.delete(`${this.context}/${x}`)
         .then(res=>{
             alert(`탈퇴가 완료되었습니다.`);
            this.arr = res.data.list   
         })
         .catch(res=>{
             alert('ERROR')
         })
      }
    }
  }
}
</script>
<style scoped>
.orange{
  background-color : #FF8F5E;
   pointer-events  : none;
}
.form-control{
  width    : 35%;
  position : absolute; 
  left     : 30%
}
#searchBtn{
  position : absolute; 
  left     : 66%
}
.pagination{
  margin-top : 50px;
}
tr{
  height : 2.2em;
}
</style>