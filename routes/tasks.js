/**
 * define an api for routing to /users path
 */
import express from 'express';
import fileSys from 'fs';

//load json file from system
var tasks;
fileSys.readFile("./db.json", function(error, content){
	tasks = JSON.parse(content);
})

// all routes here are starting with /tasks
const router = express.Router();
router.get('/:id', (req, res) => {
	const foundUser = tasks.filter(task => task.id == req.params.id);
	res.send(foundUser);
});

export default router;
