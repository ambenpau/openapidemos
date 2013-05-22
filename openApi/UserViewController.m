//
//  MenuViewController.m
//  openApi
//
//  Created by Oscar Iglesias Lopez on 16/05/13.
//  Copyright (c) 2013 Universitat Oberta de Catalunya. All rights reserved.
//

#import "UserViewController.h"

@interface UserViewController ()

@end

@implementation UserViewController

@synthesize auth, imagenUser, username, name, number, fullname, email;

- (void)viewDidLoad
{
    [super viewDidLoad];
    
	// Do any additional setup after loading the view.
    self.user = [[User alloc] init];
    [self cargarUsuario];
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (void)cargarUsuario
{
    // Definimos la URL de la API que contiene los datos del usuario.
    // Acuerdate de adjuntar en la query de la URI el token!
    NSURL *userURL = [NSURL URLWithString:
                      [NSString stringWithFormat:
                       @"http://denver.uoc.es:8080/webapps/uocapi/api/v1/user?access_token=%@", auth.accessToken]];
    
    // Hacemos el fetch de datos
    NSData *userData = [NSData dataWithContentsOfURL:userURL];
    
    // Los datos que recibimos los parseamos a una estructura mas manejable como por ejemplo NSDictionary
    NSDictionary *userDict = [NSJSONSerialization JSONObjectWithData:userData options:0 error:nil];
    
    // Los datos recibidos los pasamos al modelo
    [self.user setDatos:userDict];
    
    // Actualizamos la vista
    [self mostrarDatosUsuario];
}

- (void)mostrarDatosUsuario
{
    username.text   = self.user.username;
    name.text       = self.user.name;
    number.text     = self.user.number;
    fullname.text   = self.user.fullname;
    email.text      = self.user.email;
    imagenUser.image= self.user.photo;
}
 
@end
