import gulp from "gulp";
import gpug from "gulp-pug";
import del from "del"           // del@4.1.1
import ws from "gulp-webserver"
import image from "gulp-image"  // gulp-image@6.2.1
import gulp_sass from "gulp-sass";
import node_sass from "node-sass";
import autoprefixer from "gulp-autoprefixer"
import miniCSS from "gulp-csso"
import bro from "gulp-bro"
import babelify from "babelify"

const sass = gulp_sass(node_sass);



const routes = {
    pug: {
        watch: "src/**/*.pug",

        // src 폴더 안의 모든 pug 파일을 컴파일
        src: "src/*.pug",
        dest: "build/"
    },

    img: {
        src: "src/img/*",
        dest: "build/img/"
    },

    scss:{
        watch: "src/scss/**/*.pug",
        src: "src/scss/style.scss",
        dest: "build/css"
    },

    js: {
        watch: "src/js/**/*.js",
        src: "src/js/main.js",
        dest: "build/js"
    }
};



const pug = () => 
    gulp
    .src(routes.pug.src)                //src의 파일이 들어오면
    .pipe(gpug())                       // pug 처리를 하고
    .pipe(gulp.dest(routes.pug.dest));   // dest로 보낸다

const clean = () => del([routes.pug.dest]);

// livereload : 파일을 저장하면 자동으로 새로고침
// open : localhost로 브라우저를 Open
const webserver = () => gulp.src(routes.pug.dest).pipe(ws({livereload:true, open:true}));
const watch= () => {
    gulp.watch(routes.pug.watch, pug);
    gulp.watch(routes.img.src, img);
    gulp.watch(routes.scss.watch, styles);
    gulp.watch(routes.js.watch, js);
}



const img = () => 
    gulp
    .src(routes.img.src)
    .pipe(image())
    .pipe(gulp.dest(routes.img.dest));

const styles = () => 
    gulp
    .src(routes.scss.src)
    .pipe(sass().on('error', sass.logError))
    .pipe(autoprefixer())   // package.json에 browser 옵션 추가
    .pipe(miniCSS())        // css파일 한줄로 압축 (속도 향상)
    .pipe(gulp.dest(routes.scss.dest));;



const js = () => 
    gulp
    .src(routes.js.src)
    .pipe(bro({
        transform: [
            babelify.configure({ presets: ['@babel/preset-env'] }),
            ['uglifyify', { global: true }]     // 한줄로 압축
        ]}))
    .pipe(gulp.dest(routes.js.dest));


const prepare = gulp.series([clean, img]);
const assets = gulp.series([pug, styles, js]);
// 두가지 Task를 동시에 수행하길 원한다면 parallel사용
const postDev = gulp.parallel([webserver, watch]);    // 웹서버 실행후 변경사항 체크, 



export const dev = gulp.series([prepare, assets, postDev]);