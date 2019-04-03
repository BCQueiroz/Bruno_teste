const express = require('express');
const app = express();
const mongoose = require('mongoose');
const bodyParser = require('body-parser');
var session = require('express-session');
var store = session.MemoryStore();
const config = require('./Config/config');

const url = config;
const options = { reconnectTries: Number.MAX_VALUE, reconnectInterval: 500, poolSize: 5, useNewUrlParser: true };

mongoose.connect(url,options);
mongoose.set('useCreateIndex',true);

mongoose.connection.on('error', (err) => {
    console.log('Erro na conexao no banco de dados.' + err);
})

mongoose.connection.on('disconnected', () => {
    console.log('Aplicação desconectada do banco de dados.');
})

mongoose.connection.on('connected',() => {
    console.log('Aplicação conectada ao banco de dados.');
})

app.use(bodyParser.urlencoded({ extended: false}));
app.use(bodyParser.json());
app.use(session(
    {   
        secret: 'secretKey', 
        resave: false, 
        saveUninitialized: false, 
        cookie:{
            path: '/',
            httpOnly: false
        },
        store: store
    })
)

const indexRoute = require('./Routes/index');
const motoristaRoute = require('./Routes/Motorista');
const passageiroRoute = require('./Routes/Passageiro');
const corridaRoute = require('./Routes/Corrida');

//Definir os caminhos que deverão ser usados para se acessar as paginas do sistema via browser
app.use('/',indexRoute);
app.use('/Motorista',motoristaRoute);
app.use('/Passageiro',passageiroRoute);
app.use('/Corrida',corridaRoute);

app.use(express.static('Front'))

app.listen(3000);

module.exports = app;
