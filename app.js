/**
 * api documentation
 */
import bodyParser from 'body-parser';
import express from 'express';
import fileSys from 'fs';
import tasksRoutes from './routes/tasks.js';

const app = express();
const PORT = 3000;

app.use(bodyParser.json());
app.use('/tasks', tasksRoutes);

var tasks;
fileSys.readFile("./db.json", function(error, content){
	tasks = JSON.parse(content);
})

app.get('/tasks', (req, res) => {
	res.send(tasks);
})

app.listen(PORT, () => console.log(`Server running on port: http://localhost:${PORT}`));
