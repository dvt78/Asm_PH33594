const express = require('express')
const COMMON = require('./COMMON')

const router = express.Router()

module.exports = router
router.get('/', (req, res) => {
    res.send('Vào api mobile')
})
const mongoose = require('mongoose')
const carModel = require('./carModel')
router.get('/list', async (req, res) => {
    await mongoose.connect(COMMON.uri)
    let cars = await carModel.find()
    console.log(cars)
    res.send(cars)
})