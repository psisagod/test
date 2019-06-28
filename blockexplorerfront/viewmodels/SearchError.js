var app = new Vue({
    el: '#app',
    data: {
        recentBlocks: [],
        recentTxs: [],
        searchname: '',
        socket: '',
        stompclient: ''
    },
    computed: {
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
    },
    methods: {
        handleClick(val) {
            console.log(val);
        },
        search() {
            axios.get('/bitcoin/search', {
                params: {
                    searchname: this.searchname
                }
            })
                .then(function (response) {
                    console.log(response.data);
                    location.href = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                });
        }

    }
})