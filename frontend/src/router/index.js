import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/home'
import Mypage from '@/components/member/Mypage'
import JoinForm from '@/components/member/JoinForm'
import LoginForm from '@/components/member/LoginForm'
import Memberlist from '@/components/member/Memberlist'
import MypageUpdate from '@/components/member/MypageUpdate'
import MyInfoUpdate from '@/components/member/MyInfoUpdate'

Vue.use(Router)

export default new Router({
  mode : 'history',
  routes: [
    {
      path: '/memberlist',
      name:  'memberlist',
      component:Memberlist
    },
    {
      path: '/',
      name: 'home',
      component: Home
    }
    ,
    {
      path: '/mypage',
      name: 'mypage',
      component: Mypage
    },
    {
      path: '/mypageUpdate',
      name: 'mypageUpdate',
      component: MypageUpdate
    },
    {
      path: '/myInfoUpdate',
      name: 'myInfoUpdate',
      component: MyInfoUpdate
    },
    {
      path: '/joinForm',
      name: 'joinForm',
      component: JoinForm
    },
    {
      path: '/loginForm',
      name: 'loginForm',
      component: LoginForm
    }
  ]
})
