module.exports = {
    devServer: {
        proxy: {
            "/api":{
                target:"http://localhost:19090", //spring boot 다른ip 를 못들오게 해서 이 proxy를 통해서 다른 로컬 값 들오게 만들어줌
                pathRewrite: {
                    "^/api":"" 
                }
            }
        }
    }
};
