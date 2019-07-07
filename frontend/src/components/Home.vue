<template>
  
  <div class="hello">
    <Header></Header>
    <!-- {{msg}} -->
    
    <Body></Body>
   <Footer></Footer>
  </div>
</template>
<script>
import Header from '@/components/common/Header.vue'
import Footer from'@/components/common/Footer.vue'
import Body from'@/components/member/Body.vue'
import axios from 'axios'
export default {
  name : 'home',
  
  components:{
    Header,
    Footer,
    Body
  },
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  }
}
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight : normal;
}
ul {
  list-style-type : none;

  padding : 0;
}
li {
  display : inline-block;
  margin  : 0 10px;
}
a {
  color : #42b983;
}
</style>