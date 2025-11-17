; ModuleID = 'preamble.c'
source_filename = "preamble.c"
target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

%struct._IO_FILE = type { i32, i8*, i8*, i8*, i8*, i8*, i8*, i8*, i8*, i8*, i8*, i8*, %struct._IO_marker*, %struct._IO_FILE*, i32, i32, i64, i16, i8, [1 x i8], i8*, i64, %struct._IO_codecvt*, %struct._IO_wide_data*, %struct._IO_FILE*, i8*, i64, i32, [20 x i8] }
%struct._IO_marker = type opaque
%struct._IO_codecvt = type opaque
%struct._IO_wide_data = type opaque

@stdin = external global %struct._IO_FILE*, align 8
@stderr = external global %struct._IO_FILE*, align 8
@.str = private unnamed_addr constant [49 x i8] c"Runtime error: Got EOF when attempting to input\0A\00", align 1
@.str.1 = private unnamed_addr constant [5 x i8] c"True\00", align 1
@.str.2 = private unnamed_addr constant [6 x i8] c"False\00", align 1

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i8* @reverse_string(i8* noundef %0) #0 {
  %2 = alloca i8*, align 8
  %3 = alloca i32, align 4
  %4 = alloca i8*, align 8
  %5 = alloca i32, align 4
  store i8* %0, i8** %2, align 8
  %6 = load i8*, i8** %2, align 8
  %7 = call i64 @strlen(i8* noundef %6) #6
  %8 = trunc i64 %7 to i32
  store i32 %8, i32* %3, align 4
  %9 = load i32, i32* %3, align 4
  %10 = add nsw i32 %9, 1
  %11 = sext i32 %10 to i64
  %12 = call noalias i8* @malloc(i64 noundef %11) #7
  store i8* %12, i8** %4, align 8
  store i32 0, i32* %5, align 4
  br label %13

13:                                               ; preds = %30, %1
  %14 = load i32, i32* %5, align 4
  %15 = load i32, i32* %3, align 4
  %16 = icmp slt i32 %14, %15
  br i1 %16, label %17, label %33

17:                                               ; preds = %13
  %18 = load i8*, i8** %2, align 8
  %19 = load i32, i32* %3, align 4
  %20 = load i32, i32* %5, align 4
  %21 = sub nsw i32 %19, %20
  %22 = sub nsw i32 %21, 1
  %23 = sext i32 %22 to i64
  %24 = getelementptr inbounds i8, i8* %18, i64 %23
  %25 = load i8, i8* %24, align 1
  %26 = load i8*, i8** %4, align 8
  %27 = load i32, i32* %5, align 4
  %28 = sext i32 %27 to i64
  %29 = getelementptr inbounds i8, i8* %26, i64 %28
  store i8 %25, i8* %29, align 1
  br label %30

30:                                               ; preds = %17
  %31 = load i32, i32* %5, align 4
  %32 = add nsw i32 %31, 1
  store i32 %32, i32* %5, align 4
  br label %13, !llvm.loop !6

33:                                               ; preds = %13
  %34 = load i8*, i8** %4, align 8
  %35 = load i32, i32* %3, align 4
  %36 = sext i32 %35 to i64
  %37 = getelementptr inbounds i8, i8* %34, i64 %36
  store i8 0, i8* %37, align 1
  %38 = load i8*, i8** %4, align 8
  ret i8* %38
}

; Function Attrs: nounwind readonly willreturn
declare i64 @strlen(i8* noundef) #1

; Function Attrs: nounwind allocsize(0)
declare noalias i8* @malloc(i64 noundef) #2

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i8* @concat_strings(i8* noundef %0, i8* noundef %1) #0 {
  %3 = alloca i8*, align 8
  %4 = alloca i8*, align 8
  %5 = alloca i8*, align 8
  store i8* %0, i8** %3, align 8
  store i8* %1, i8** %4, align 8
  %6 = load i8*, i8** %3, align 8
  %7 = call i64 @strlen(i8* noundef %6) #6
  %8 = load i8*, i8** %4, align 8
  %9 = call i64 @strlen(i8* noundef %8) #6
  %10 = add i64 %7, %9
  %11 = add i64 %10, 1
  %12 = call noalias i8* @malloc(i64 noundef %11) #7
  store i8* %12, i8** %5, align 8
  %13 = load i8*, i8** %5, align 8
  %14 = load i8*, i8** %3, align 8
  %15 = call i8* @strcpy(i8* noundef %13, i8* noundef %14) #8
  %16 = load i8*, i8** %5, align 8
  %17 = load i8*, i8** %4, align 8
  %18 = call i8* @strcat(i8* noundef %16, i8* noundef %17) #8
  %19 = load i8*, i8** %5, align 8
  ret i8* %19
}

; Function Attrs: nounwind
declare i8* @strcpy(i8* noundef, i8* noundef) #3

; Function Attrs: nounwind
declare i8* @strcat(i8* noundef, i8* noundef) #3

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i8* @read_line() #0 {
  %1 = alloca i8*, align 8
  %2 = alloca i64, align 8
  %3 = alloca i64, align 8
  store i8* null, i8** %1, align 8
  %4 = load %struct._IO_FILE*, %struct._IO_FILE** @stdin, align 8
  %5 = call i64 @getline(i8** noundef %1, i64* noundef %2, %struct._IO_FILE* noundef %4)
  store i64 %5, i64* %3, align 8
  %6 = load i64, i64* %3, align 8
  %7 = icmp sle i64 %6, 0
  br i1 %7, label %8, label %11

8:                                                ; preds = %0
  %9 = load %struct._IO_FILE*, %struct._IO_FILE** @stderr, align 8
  %10 = call i32 (%struct._IO_FILE*, i8*, ...) @fprintf(%struct._IO_FILE* noundef %9, i8* noundef getelementptr inbounds ([49 x i8], [49 x i8]* @.str, i64 0, i64 0))
  call void @exit(i32 noundef 7) #9
  unreachable

11:                                               ; preds = %0
  %12 = load i8*, i8** %1, align 8
  %13 = load i64, i64* %3, align 8
  %14 = sub nsw i64 %13, 1
  %15 = getelementptr inbounds i8, i8* %12, i64 %14
  store i8 0, i8* %15, align 1
  %16 = load i8*, i8** %1, align 8
  ret i8* %16
}

declare i64 @getline(i8** noundef, i64* noundef, %struct._IO_FILE* noundef) #4

declare i32 @fprintf(%struct._IO_FILE* noundef, i8* noundef, ...) #4

; Function Attrs: noreturn nounwind
declare void @exit(i32 noundef) #5

; Function Attrs: noinline nounwind optnone uwtable
define dso_local void @print_bool(i1 noundef zeroext %0) #0 {
  %2 = alloca i8, align 1
  %3 = zext i1 %0 to i8
  store i8 %3, i8* %2, align 1
  %4 = load i8, i8* %2, align 1
  %5 = trunc i8 %4 to i1
  br i1 %5, label %6, label %8

6:                                                ; preds = %1
  %7 = call i32 @puts(i8* noundef getelementptr inbounds ([5 x i8], [5 x i8]* @.str.1, i64 0, i64 0))
  br label %10

8:                                                ; preds = %1
  %9 = call i32 @puts(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str.2, i64 0, i64 0))
  br label %10

10:                                               ; preds = %8, %6
  ret void
}

declare i32 @puts(i8* noundef) #4

; Function Attrs: noinline nounwind optnone uwtable
define dso_local zeroext i1 @string_less(i8* noundef %0, i8* noundef %1) #0 {
  %3 = alloca i8*, align 8
  %4 = alloca i8*, align 8
  store i8* %0, i8** %3, align 8
  store i8* %1, i8** %4, align 8
  %5 = load i8*, i8** %3, align 8
  %6 = load i8*, i8** %4, align 8
  %7 = call i32 @strcmp(i8* noundef %5, i8* noundef %6) #6
  %8 = icmp slt i32 %7, 0
  ret i1 %8
}

; Function Attrs: nounwind readonly willreturn
declare i32 @strcmp(i8* noundef, i8* noundef) #1

; Function Attrs: noinline nounwind optnone uwtable
define dso_local zeroext i1 @string_contains(i8* noundef %0, i8* noundef %1) #0 {
  %3 = alloca i8*, align 8
  %4 = alloca i8*, align 8
  store i8* %0, i8** %3, align 8
  store i8* %1, i8** %4, align 8
  %5 = load i8*, i8** %3, align 8
  %6 = load i8*, i8** %4, align 8
  %7 = call i8* @strstr(i8* noundef %5, i8* noundef %6) #6
  %8 = icmp ne i8* %7, null
  ret i1 %8
}

; Function Attrs: nounwind readonly willreturn
declare i8* @strstr(i8* noundef, i8* noundef) #1

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i8* @bool_to_string(i1 noundef zeroext %0) #0 {
  %2 = alloca i8*, align 8
  %3 = alloca i8, align 1
  %4 = alloca i8*, align 8
  %5 = alloca i8*, align 8
  %6 = zext i1 %0 to i8
  store i8 %6, i8* %3, align 1
  %7 = load i8, i8* %3, align 1
  %8 = trunc i8 %7 to i1
  br i1 %8, label %9, label %14

9:                                                ; preds = %1
  %10 = call noalias i8* @malloc(i64 noundef 5) #7
  store i8* %10, i8** %4, align 8
  %11 = load i8*, i8** %4, align 8
  %12 = call i8* @strcpy(i8* noundef %11, i8* noundef getelementptr inbounds ([5 x i8], [5 x i8]* @.str.1, i64 0, i64 0)) #8
  %13 = load i8*, i8** %4, align 8
  store i8* %13, i8** %2, align 8
  br label %19

14:                                               ; preds = %1
  %15 = call noalias i8* @malloc(i64 noundef 6) #7
  store i8* %15, i8** %5, align 8
  %16 = load i8*, i8** %5, align 8
  %17 = call i8* @strcpy(i8* noundef %16, i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str.2, i64 0, i64 0)) #8
  %18 = load i8*, i8** %5, align 8
  store i8* %18, i8** %2, align 8
  br label %19

19:                                               ; preds = %14, %9
  %20 = load i8*, i8** %2, align 8
  ret i8* %20
}

attributes #0 = { noinline nounwind optnone uwtable "frame-pointer"="all" "min-legal-vector-width"="0" "no-trapping-math"="true" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "tune-cpu"="generic" }
attributes #1 = { nounwind readonly willreturn "frame-pointer"="all" "no-trapping-math"="true" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "tune-cpu"="generic" }
attributes #2 = { nounwind allocsize(0) "frame-pointer"="all" "no-trapping-math"="true" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "tune-cpu"="generic" }
attributes #3 = { nounwind "frame-pointer"="all" "no-trapping-math"="true" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "tune-cpu"="generic" }
attributes #4 = { "frame-pointer"="all" "no-trapping-math"="true" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "tune-cpu"="generic" }
attributes #5 = { noreturn nounwind "frame-pointer"="all" "no-trapping-math"="true" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "tune-cpu"="generic" }
attributes #6 = { nounwind readonly willreturn }
attributes #7 = { nounwind allocsize(0) }
attributes #8 = { nounwind }
attributes #9 = { noreturn nounwind }

!llvm.module.flags = !{!0, !1, !2, !3, !4}
!llvm.ident = !{!5}

!0 = !{i32 1, !"wchar_size", i32 4}
!1 = !{i32 7, !"PIC Level", i32 2}
!2 = !{i32 7, !"PIE Level", i32 2}
!3 = !{i32 7, !"uwtable", i32 2}
!4 = !{i32 7, !"frame-pointer", i32 2}
!5 = !{!"Ubuntu clang version 15.0.7"}
!6 = distinct !{!6, !7}
!7 = !{!"llvm.loop.mustprogress"}
define i32 @main() {
  %reg1 = getelementptr inbounds [23 x i8], [23 x i8]* @lit1, i64 0, i64 0
  call i32 @puts(i8* %reg1)
  %reg2 = call i8* @read_line()
  %reg3 = alloca i8*, align 8
  store i8* %reg2, i8** %reg3
  %reg4 = getelementptr inbounds [18 x i8], [18 x i8]* @lit2, i64 0, i64 0
  call i32 @puts(i8* %reg4)
  %reg5 = load i8*, i8** %reg3
  %reg6 = getelementptr inbounds [7 x i8], [7 x i8]* @lit3, i64 0, i64 0
  %reg7 = call i1 @string_contains(i8* %reg5, i8* %reg6)
  %reg8 = alloca i1, align 1
  store i1 %reg7, i1* %reg8
  %reg9 = load i1, i1* %reg8
  br i1 %reg9, label %if_true_L1, label %if_false_L1
if_true_L1:
  %reg10 = getelementptr inbounds [51 x i8], [51 x i8]* @lit4, i64 0, i64 0
  call i32 @puts(i8* %reg10)
  br label %if_end_L1
if_false_L1:
  %reg11 = getelementptr inbounds [21 x i8], [21 x i8]* @lit5, i64 0, i64 0
  call i32 @puts(i8* %reg11)
  br label %if_end_L1
if_end_L1:
  ret i32 0
}
@lit1 = constant [23 x i8] c"Hey, what's your name?\00"
@lit2 = constant [18 x i8] c"Analyzing name...\00"
@lit3 = constant [7 x i8] c"hunter\00"
@lit4 = constant [51 x i8] c"wow! it is such an honor to meet you. I love you<3\00"
@lit5 = constant [21 x i8] c"K. Nice to meet you.\00"
