var app = new Vue({
    el: '#app',
    data: {
        blocks: []
    },
    mounted() {
        this.getMoreBlocks();
    },
    methods: {
        getMoreBlocks() {
            axios.get('/block/getMoreBlocks')
                .then(function (response) {
                    // handle success
                    console.log(response);
                    app.blocks = response.data;

                })
                .catch(function (error) {
                    // handle error
                    console.log(error);
                });
        }
    }
})