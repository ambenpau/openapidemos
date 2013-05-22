//
//  MenuViewController.m
//  openApi
//
//  Created by macoscar on 16/05/13.
//  Copyright (c) 2013 Universitat Oberta de Catalunya. All rights reserved.
//

#import "MenuViewController.h"

@interface MenuViewController ()

@end

@implementation MenuViewController

@synthesize auth, imagenUser, username, name, number, fullname, email;

- (void)viewDidLoad
{
    [super viewDidLoad];
    [self cargarUsuario];
	// Do any additional setup after loading the view.
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (void)cargarUsuario
{
    NSString *url = [NSString stringWithFormat:@"http://denver.uoc.es:8080/webapps/uocapi/api/v1/user?access_token=%@", auth.accessToken];
    Json *jsonParser = [[Json alloc] init];
    [jsonParser startLoadingObjectWithUrl:url andDelegate:self];
}

- (void)dataRequestCompletedWithJsonObject:(id)jsonObject
{
    NSDictionary *userDictionary = (NSDictionary *)jsonObject;
    User *user = [[User alloc] init];
    
    [user setUsername:[userDictionary objectForKey:@"username"]];
    [user setName:[userDictionary objectForKey:@"name"]];
    [user setNumber:[userDictionary objectForKey:@"number"]];
    [user setFullname:[userDictionary objectForKey:@"fullName"]];
    [user setEmail:[userDictionary objectForKey:@"email"]];
    [user setPhotoURL:[userDictionary objectForKey:@"photoUrl"]];
    
    username.text = user.username;
    name.text = user.name;
    number.text = user.number;
    fullname.text = user.fullname;
    email.text = user.email;
    
    NSData *imgData = [NSData dataWithContentsOfURL:[NSURL URLWithString:user.photoURL]];
    imagenUser.image = [UIImage imageWithData:imgData];
    
    //NSLog(@"%@", user.fullname);
}

@end
