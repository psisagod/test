var app = new Vue({
    el: '#app',
    data: {
        blockDetail: ''
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
                    app.blockDetail = response.data;

                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
})