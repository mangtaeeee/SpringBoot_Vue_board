<template>
    <div class="hello">
        <h1>게시판</h1>
        <div><!-- 콤보박스 선택 type="value"-->
          <b-form-select v-model="type" :options="options" class="mb-2 mr-sm-2 mb-sm-0">
          </b-form-select>
            <input type="text" id="param" v-model="param" >                
            <!--버튼 클릭시 get방식으로 값 요청--->
            <button  @click="getBoard()">Get검색</button>
            <!--버튼 클릭시 post 방식으로 값 요청-->
            <button @click="postBoard()" >post검색</button>
            <!--받아온 값 작성자 확인 텍스트-->
            작성자 : <input type="text" id="createid" v-model="serch">
        </div>
        <table>
            <thead>
                <tr>
                    <th>글번호</th>
                    <th>제목</th>
                    <th>내용</th>
                    <th>작성자</th>
                    <th>작성일시</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="board in filteredPosts" :key="board.boardId">
                    <td>{{ board.boardId }}</td>
                    <td>{{ board.title }}</td>
                    <td>{{ board.contents }}</td>
                    <td>{{ board.userNm }} <br />({{ board.createId }})</td>
                    <td>{{ board.createDtime }}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import axios from "axios";



export default {
    name: "boardList",
    data() {
        return {
            boards : [],
            param : "",
            type : "non",
            createid : "",
            serch : "",
            options:[ //select를 위한 선언
                {value:"non",text:"선택"},
                {value:"title",text:"제목"},
                {value:"contents",text:"내용"},
                {value:"userNm",text:"작성자"},
            ]
        };
    },
    methods: {
        //리스트 출력
        getBoard() {
            axios.get("api/list",{
                params:{
                    type:this.type, //type 의 현재 입력값 아직은 "" 상태
                    param:this.param //param 의 현재 입력값 아직은 "" 상태
                    
                }
            })
                .then(response => { // 호출 성공시
                    this.boards =  response.data; // boards 의 값에 적용
                })
                .catch(error => {
                    console.log(error);
                });    
        },
        postBoard(){
            axios.post("api/list",{
                type:this.type,
                param:this.param
            })
                .then(response => { // 호출 성공시
                    this.boards =  response.data; // boards 의 값에 적용
                })
                .catch(error => {
                    console.log(error);
                });   
        },      
    },
    computed:{
        filteredPosts(){
            return this.boards.filter(board => board.userNm.includes(this.serch)); // 실시간으로 변하는 작성자의 값따라 검색
        }
    }
};
</script>
<style scoped>
table {
    border: 1px solid black;
    border-collapse: collapse;
    width: 1000px;
    height: 250px;
    margin-left: auto;
    margin-right: auto;
}
thead {
    border: 1px solid black;
    background-color: skyblue;
}

th, td, tbody{
    border: 1px solid black;
    border-collapse: collapse;
}

select ,input ,button {
    height : 29px;
}
</style>
