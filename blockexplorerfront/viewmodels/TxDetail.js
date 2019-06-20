var app = new Vue({
    el: '#app',
    data: {
        TxDetail: []
    },
    mounted() {
        console.log('view mounted');
        var url = new URL(location.href);
        var searchname = url.searchParams.get("searchname");
        this.getBlock(searchname);
        console.log(searchname);
    },
    methods: {
        getBlock(searchname) {
            axios.get('/bitcoin/search', {
                params: {
                    searchname: searchname
                }
            })
                .then(function (response) {
                    console.log(response);
                    app.TxDetail = response.data;

                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        gettxbyhash(txhash){
            console.log(txhash);
            location.href = "TxDetail.html?searchname=" + txhash;
        }
    }
})