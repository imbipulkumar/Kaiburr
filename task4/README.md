# Task 4

:globe_with_meridians: :rocket: [LIVE APP](http://3.18.207.40/)

**NOTE:** [README First](/README.md)

### Requirements

- Node
- Docker

#### Dependencies

- axios	//Promise based HTTP client for the browser and node.js
- bootstrap
- react
- react-dom
- react-scripts
- react-toastify	//To generate toast message
- reactstrap

## Building steps

1. Open the folder `/task2` in your favourite IDE ( VS Code :heart:)
Wait for few minutes while the IDE loads and completes necessary pre-build tasks.

2. Run `npm install`
This will install dependencies.

3. Run `npm start`
React application will start on port `3000` of the `localhost`.

4. Run `npm run build`
This will build the artifacts in `/build` folder.

## CRUD methods

```javascript
createServer();	//axios.put
    
deleteServer(id);	//axios.delete
    
findServerById(id);	//axios.get

findServerByName(name);	//axios.get
```

#### Screenshots

![WebUiFormGIF](/screenshots/task4WebUiForm.gif)

![WebUIForm](/screenshots/task4WebUIForm.PNG)

![CreateWebUIForm](/screenshots/createWebUIForm.PNG)

## Containerizing the app

`Dockerfile` contains all the commands required to build the app image

`
FROM nginx:alpine
COPY /build /usr/share/nginx/html
EXPOSE 80
ENTRYPOINT ["nginx", "-g", "daemon off;"]
`

1. Run the following command to build docker image
`sudo docker build -t <container_image_name> .`
This will create the app container image and add to you local repository.

2. To Run the app from container, run the following command
`sudo docker run -p 80:3000 <container_image_name>`
React Web Application will load and start on port `3000` of the `localhost`
You will see application logs in the terminal.

**Note:** *The docker-compose part is Documented in Task3*

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.<br />
Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

The page will reload if you make edits.<br />
You will also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.<br />
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

### `npm run build`

Builds the app for production to the `build` folder.<br />
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.<br />
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

### `npm run eject`

**Note: this is a one-way operation. Once you `eject`, you can’t go back!**

If you aren’t satisfied with the build tool and configuration choices, you can `eject` at any time. This command will remove the single build dependency from your project.

Instead, it will copy all the configuration files and the transitive dependencies (webpack, Babel, ESLint, etc) right into your project so you have full control over them. All of the commands except `eject` will still work, but they will point to the copied scripts so you can tweak them. At this point you’re on your own.

You don’t have to ever use `eject`. The curated feature set is suitable for small and middle deployments, and you shouldn’t feel obligated to use this feature. However we understand that this tool wouldn’t be useful if you couldn’t customize it when you are ready for it.

## Learn More

You can learn more in the [Create React App documentation](https://facebook.github.io/create-react-app/docs/getting-started).

To learn React, check out the [React documentation](https://reactjs.org/).

### Code Splitting

This section has moved here: https://facebook.github.io/create-react-app/docs/code-splitting

### Analyzing the Bundle Size

This section has moved here: https://facebook.github.io/create-react-app/docs/analyzing-the-bundle-size

### Making a Progressive Web App

This section has moved here: https://facebook.github.io/create-react-app/docs/making-a-progressive-web-app

### Advanced Configuration

This section has moved here: https://facebook.github.io/create-react-app/docs/advanced-configuration

### Deployment

This section has moved here: https://facebook.github.io/create-react-app/docs/deployment

### `npm run build` fails to minify

This section has moved here: https://facebook.github.io/create-react-app/docs/troubleshooting#npm-run-build-fails-to-minify

**If run into problem, do not hesitate to comment or connect :smile: !**