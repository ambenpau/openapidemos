//
//  TeachingMaterial.h
//  Llibreria
//
//  Created by UOC on 09/09/13.
//  Copyright (c) 2013 Universitat Oberta de Catalunya. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface TeachingMaterial : NSObject

@property (nonatomic, retain) NSString *identifier; //Material's idenfitier.
@property (nonatomic, retain) NSString *type; //Material's type (PDF, WEB).
@property (nonatomic, retain) NSString *title; //Material's title.
@property (nonatomic, retain) NSString *url; //Material's URL.

-(void) setDatos:(NSDictionary *) materialDictionary;

@end
