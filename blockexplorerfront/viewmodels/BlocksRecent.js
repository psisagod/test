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
        this.getRecentBlocks();
        this.handleRecentTxs();
        //this.getRecentTxs();
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
        handleRecentTxs() {
            console.log('connect click');
            this.socket = new SockJS('http://localhost:8080/cjfstompsrv2');
            this.stompclient = Stomp.over(this.socket);
            this.stompclient.connect({}, frame => {
                console.log(frame);
                this.stompclient.subscribe('/mytopic/greetings', function (data) {
                    //var str = this.string2Array(data.body);
                    var str = JSON.parse(data.body)
                    console.log(str)
                    app.recentTxs = str;
                });
            });

        },
        getRecentTxs() {
            axios.get('/tx/getRecentTxs')
                .then(function (response) {
                    // handle success
                    console.log(response);
                    app.recentTxs = response.data;
                })
                .catch(function (error) {
                    // handle error
                    console.log(error);
                });3.
        },
        handleClick(val) {
            console.log(val);
        },
        search() {
            location.href = "BlockDetail.html?searchname=" + this.searchname;
        },
        getblockbyheight(row){
            console.log(row);
            location.href = "BlockDetail.html?searchname=" + row;
        },
        gettxbyhash(row){
            console.log(row);
            location.href = "TxDetail.html?searchname=" + row;
        }
    }
})