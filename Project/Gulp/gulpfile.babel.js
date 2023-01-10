import gulp from "gulp";
import gpug from "gulp-pug";
import del from "del"   // del@4.1.1
import ws from "gulp-webserver"

const routes = {
    pug: {
        watch: "src/**/*.pug",
        // src 폴더 안의 모든 pug 파일을 컴파일
        src: "src/*.pug",
        dest: "build"
    }
};

const pug = () => 
    gulp
    .src(routes.pug.src)                //src의 파일이 들어오면
    .pipe(gpug())                       // pug 처리를 하고
    .pipe(gulp.dest(routes.pug.dest));   // dest로 보낸다

const clean = () => del(["build/"]);

// livereload : 파일을 저장하면 자동으로 새로고침
// open : localhost로 브라우저를 Open
const webserver = () => gulp.src("build").pipe(ws({livereload:true, open:true}));
const watch= () => gulp.watch(routes.pug.watch, pug);

const prepare = gulp.series([clean])
const assets = gulp.series([pug])
// 두가지 Task를 동시에 수행하길 원한다면 parallel사용
const postDev = gulp.parallel([webserver, watch]);    // 웹서버 실행후 변경사항 체크, 

export const dev = gulp.series([prepare, assets, postDev]);