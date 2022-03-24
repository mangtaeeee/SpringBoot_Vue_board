import Vue from "vue";
import VueRouter from "vue-router";
import Home from "./components/board/Home";
import List from "./components/board/List";



Vue.use(VueRouter);
//밑에 주석은 eslint 에서 오류 처리 나서 예외처리위해 붙여줌 
const router = new VueRouter({ // eslint-disable-line no-unused-vars
    mode : "history",
    routes : [
        {
            path:"/", 
            component: Home
        },
        {
            path:"/list",
            component : List 
        },
    ]
});
export default router;

