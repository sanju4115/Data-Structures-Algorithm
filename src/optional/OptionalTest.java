package com.optional;

import com.justcredo.springbootaerospikeexample.model.Product;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        // let's assume you will get this from your model in the future; in the meantime...
        Product product = new Product();
        product.setImageUrl(null);
        Optional<String> optional = test(product);
        optional.ifPresent(System.out::println);

        ScreenResolution resolution = new ScreenResolution(750,1334);
        DisplayFeatures dfeatures = new DisplayFeatures("4.7", resolution);
        Mobile mobile = new Mobile(2015001, "Apple", "iPhone 6s", dfeatures);

        MobileService mService = new MobileService();

        int width = mService.getMobileScreenWidth(Optional.of(mobile));
        System.out.println("Apple iPhone 6s Screen Width = " + width);

        Mobile mobile2 = new Mobile(2015001, "Apple", "iPhone 6s", null);
        int width2 = mService.getMobileScreenWidth(Optional.ofNullable(mobile2));
        System.out.println("Apple iPhone 16s Screen Width = " + width2);

    }

    private static Optional<String> test(Product product){
        Optional<Product> optionalProject = Optional.ofNullable(product);
        Optional<String> optionalTypeDirName = optionalProject
                .flatMap(Product::getOptionalImageUrl)
                .map(String::toUpperCase);
        optionalTypeDirName.ifPresent(System.out::println);
        return optionalTypeDirName;
    }


}
