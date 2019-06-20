var app = new Vue({
    el: '#app',
    data: {
        recentBlocks:[],
        searchname:''
    },
    computed:{
        //todo
        // showRecentBlocks(){
        //     this.recentBlocks.forEach(block => {
        //         block.age= block.age+"saasa";
        //     });
        //     return this.recentBlocks;
        // }
    },
    mounted() {
        console.log('view mounted');
        this.getRecentBlocks();
    },
    methods: {
        getRecentBlocks() {
            axios.get('/block/getRecentBlocks')
                .then(function (response) {
                    // handle success
                    console.log(response);
                    app.recentBlocks = response.data;
                    
                })
                .catch(function (error) {
                    // handle error
                    console.log(error);
                });
        },
        handleClick(val){
            console.log(val);
        },
        search() {
            location.href="BlockDetail.html?searchname="+this.searchname
        }
    }
})