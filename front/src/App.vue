<template>
    <div id="app">
        <Header />
        <div id="content" class="content">
           <router-view></router-view>
        </div>
        
    </div>
    
</template>

<script>

import Header from "./components/layout/Header.vue";


export default {
    name: "App",
    components: {
        Header,
    },
};
</script>

<style>
#app {
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
}
</style>
