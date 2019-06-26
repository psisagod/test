var app = new Vue({
    el: '#app',
    data: {
        blockDetail: ''
    },
    mounted() {
        console.log('view mounted');
        var url = new URL(location.href);
        var searchname = url.searchParams.get("searchname");
        if(searchname.length>7){
            this.getBlockByBlockHash(searchname);
        }else{
            this.getBlockByBlockHeight(searchname);
        }
        console.log(searchname);
        
    },
    methods: {
        getBlockByBlockHash(searchname) {
            axios.get('/block/searchBlockByBlockHash', {
                params: {
                    blockhash: searchname
                }
            })
                .then(function (response) {
                    console.log(response);
                    app.blockDetail = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        getBlockByBlockHeight(searchname) {
            axios.get('/block/searchBlockByBlockHeight', {
                params: {
                    blockheight: searchname
                }
            })
                .then(function (response) {
                    console.log(response);
                    app.blockDetail = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
})