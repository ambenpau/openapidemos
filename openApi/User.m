//
//  User.m
//  openApi
//
//  Created by Oscar Iglesias Lopez on 17/05/13.
//  Copyright (c) 2013 Universitat Oberta de Catalunya. All rights reserved.
//

#import "User.h"

@implementation User

@synthesize identifier, username, name, number, fullname, photo, language, sessionID, email;

- (void) setDatos:(NSDictionary *)userDictionary
{
    identifier  = [userDictionary objectForKey:@"id"];
    username    = [userDictionary objectForKey:@"username"];
    name        = [userDictionary objectForKey:@"name"];
    number      = [userDictionary objectForKey:@"number"];
    fullname    = [userDictionary objectForKey:@"fullName"];
    language    = [userDictionary objectForKey:@"language"];
    sessionID   = [userDictionary objectForKey:@"sessionID"];
    email       = [userDictionary objectForKey:@"email"];
    
    NSURL *photoURL = [NSURL URLWithString:[userDictionary objectForKey:@"photoUrl"]];
    NSData *photoData = [NSData dataWithContentsOfURL:photoURL];
    photo = [UIImage imageWithData:photoData];
}

@end