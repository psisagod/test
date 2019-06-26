var app = new Vue({
    el: '#app',
    data: {
        txs: []
    },
    mounted() {
        this.getMoreBlocks();
    },
    methods: {
        getMoreBlocks() {
            axios.get('/tx/getMoreTxs')
                .then(function (response) {
                    // handle success
                    console.log(response);
                    app.txs = response.data;

                })
                .catch(function (error) {
                    // handle error
                    console.log(error);
                });
        }
    }
})