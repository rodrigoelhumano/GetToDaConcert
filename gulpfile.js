var gulp = require('gulp'),
    concat = require('gulp-concat'),
    uglify = require('gulp-uglify'),
    minifyCss = require('gulp-minify-css');

gulp.task('scriptsBulk', function() {
    return gulp.src(['public/javascripts/jquery-2.1.4.min.js', 'public/javascripts/bootstrap-3.3.5.min.js',
    'public/javascripts/fastclick.min.js', 'public/javascripts/icheck.min.js'])
    .pipe(concat('application.js'))
    .pipe(uglify())
    .pipe(gulp.dest('public/build/'));
});

gulp.task('scriptsOut', ['scriptsBulk'], function() {
    gulp.src(['public/build/application.js', 'public/javascripts/jquery-easing.min.js',
    'public/javascripts/classie.js', 'public/javascripts/cbpAnimatedHeader.js',
    'public/javascripts/cbpAnimatedHeader.min.js', 'public/javascripts/freelancer.js'])
    .pipe(concat('appOut.js'))
    .pipe(uglify())
    .pipe(gulp.dest('public/build/'));
});

gulp.task('scriptsIn', ['scriptsOut'], function() {
    gulp.src(['public/build/application.js', 'public/javascripts/jquery.slimscroll.min.js',
    'public/javascripts/app.min.js'])
    .pipe(concat('appIn.js'))
    .pipe(uglify())
    .pipe(gulp.dest('public/build/'));
});

gulp.task('styleOut', function() {
    gulp.src(['public/stylesheets/bootstrap-3.3.5.min.css', 'public/stylesheets/outSystem.css'])
    .pipe(concat('appOut.css'))
    .pipe(minifyCss())
    .pipe(gulp.dest('public/build/'));
});

gulp.task('styleIn', ['styleOut'], function() {
    gulp.src(['public/stylesheets/bootstrap-3.3.5.min.css', 'public/stylesheets/AdminLTE.min.css',
    'public/stylesheets/skin-red.css'])
    .pipe(concat('appIn.css'))
    .pipe(minifyCss())
    .pipe(gulp.dest('public/build/'));
});