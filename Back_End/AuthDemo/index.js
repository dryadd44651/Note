const express = require('express');
const app = express();
const User = require('./models/user');
const mongoose = require('mongoose');
const bcrypt = require('bcrypt');
const session = require('express-session');
//const cors = require('cors');


//mongoose.connect("mongodb+srv://Howard:0324@cluster0-elldn.mongodb.net/loginDemo?retryWrites=true&w=majority")

mongoose.connect('mongodb+srv://Howard:0324@cluster0-elldn.mongodb.net/loginDemo?retryWrites=true&w=majority', { useNewUrlParser: true, useUnifiedTopology: true })
    .then(() => {
        console.log("MONGO CONNECTION OPEN!!!")
    })
    .catch(err => {
        console.log("OH NO MONGO CONNECTION ERROR!!!!")
        console.log(err)
    })


app.set('view engine', 'ejs');
app.set('views', 'views');
//app.use(cors());
//app.use(cors({ origin: true }));
app.use(express.urlencoded({ extended: true }));
app.use(session({ secret: 'notagoodsecret' }))

const requireLogin = (req, res, next) => {
    if (!req.session.user_id) {
        return res.redirect('/login')
    }
    next();
}
//app.get('/', (req, res) => {
//    res.send('THIS IS THE HOME PAGE')
//})

app.get('/register', (req, res) => {
    res.render('register')
})

app.post('/register', async (req, res) => {
    const { password, username } = req.body;
    const user = new User({ username, password })
    await user.save();
    req.session.user_id = user._id;
    res.redirect('/')
})

app.get('/login', (req, res) => {
    res.render('login')
})
app.post('/login', async (req, res) => {
	console.log(req.body);
    const { username, password } = req.body;
	try{
		const foundUser = await User.findAndValidate(username, password);
		if (foundUser) {
			req.session.user_id = foundUser._id;
			res.redirect('/secret');
		}
		else {
			res.redirect('/login')
		}
	}catch(err){
        res.json({message: err});
    }
	
    
})

app.post('/logout', (req, res) => {
    req.session.user_id = null;
    // req.session.destroy();
    res.redirect('/login');
})

app.get('/secret', requireLogin, (req, res) => {
    res.render('secret')
})
app.get('/topsecret', requireLogin, (req, res) => {
    res.send("TOP SECRET!!!")
})

app.listen(1000, () => {
    console.log("SERVING YOUR APP!")
})

