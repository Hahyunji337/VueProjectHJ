<template class="wrapper">
    <footer class="footer-demo section-dark">
        <div class="container">
            <nav class="pull-left">
                <ul >
                    <li>
                        <a href="mailto:gaulbaram111@naver.com">
                            문의 gaulbaram111@naver.com
                        </a>
                    </li>
                    <li>
                        <a href="#">
                        서비스 이용약관
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            개인정보 처리방침
                        </a>
                    </li>
                </ul>
            </nav>
            <div class="copyright pull-right" id="copyright">
                &copy; 2019, made with <i class="fa fa-heart heart"></i> Trip MoA
            </div>
        </div>
    </footer>
</template>
<script>
export default {
    
}
</script>
<style scoped>
@media (min-width : 768px){
.footer-demo {
    position      : absolute;
    bottom        : 0;
    padding-top   : 20px;
    width         : 100%;
    height        : 14%; 
    margin-bottom : 0;  
    }
}
@media (max-width: 767px) {
  #copyright{
    visibility : hidden;
    position   : relative;
  }
  .footer-demo{
      position      : relative;
      bottom        : 0;
      margin-bottom : 0;
  }
}
</style>