package com.library.libraryservice.exception;

public record ExceptionMessage(String timestamp, int status, String error,String message,String path) {
    //record: bir sınf tipi. Record Jvm de final class yaratıyorve bu final class içeriisnde constructor ve get memthodları oluyor.
    // immutable bir nesne yaratmamızı sağlıyor.Bir data sındııfıdır. ve immutable yani değiştirilemez durumlarda kullanılır.
    // sınıflar aynı özelliklere ve datalara sahip olsalar bile ClassA=ClassB diyemeyiz. ama bu durum recordda denebilir.
    // spring jpa final olan bir construstorı yani extend edılemeyen yapıyı kullanamadıgı için recordlarda entity kısmında kullanılmıyor.
    
}
