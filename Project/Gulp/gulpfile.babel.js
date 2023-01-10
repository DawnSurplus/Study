import gulp from "gulp";
import gpug from "gulp-pug";
import del from "del"   // del@4.1.1

const routes = {
    pug: {
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

const prepare = gulp.series([clean])

const assets = gulp.series([pug])

export const dev = gulp.series([prepare, assets]);