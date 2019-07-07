<template>
   <div class="wrapper">
     <div class="demo-header demo-header-image">
            <div class="motto">
                <br><br><br><br><br><br>
                <h1 class="title-uppercase">Trip MoA</h1> 
                <h3>세상의 모든 여행 </h3>
            </div>     
    </div>
   </div>
</template>
<script>
export default {
  
}
</script>
<style scoped>

.demo-header.demo-header-image{
      min-height : 100vh;
}
@media (max-width: 767px) {
  .motto {
    visibility : hidden;
  }
  .demo-header.demo-header-image{
      min-height : 95.5vh;
  }
}
@media (max-width: 570px) {
  .demo-header.demo-header-image{
      min-height : 86vh;
  }
}
</style>