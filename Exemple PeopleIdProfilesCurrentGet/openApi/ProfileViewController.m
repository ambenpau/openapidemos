//
//  ProfileViewController.m
//  Ejemplo1
//
//  Created by UOC on 24/07/13.
//  Copyright (c) 2013 Universitat Oberta de Catalunya. All rights reserved.
//

#import "ProfileViewController.h"

@interface ProfileViewController ()

@end

@implementation ProfileViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
    self.profile = [[Profile alloc] init];
	// Do any additional setup after loading the view.
    [self cargarPerfil];
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (void)cargarPerfil
{
    [[UIApplication sharedApplication] setNetworkActivityIndicatorVisible:YES];
    // Definim la url que mostra el perfil actual de l'usuari.
    NSURL *profilesURL = [NSURL URLWithString:[NSString stringWithFormat:@"http://denver.uoc.es:8080/webapps/uocapi/api/v1/people/%@/profiles/current?access_token=%@", self.person.identifier, self.auth.accessToken]];
    
    dispatch_queue_t backgroundQueue = dispatch_get_global_queue(DISPATCH_QUEUE_PRIORITY_BACKGROUND, 0);
    
    dispatch_async(backgroundQueue, ^{
        NSData *profilesData = [NSData dataWithContentsOfURL:profilesURL];
        
        NSDictionary *profilesDict = [NSJSONSerialization JSONObjectWithData:profilesData options:0 error:nil];
        
        if ([profilesDict valueForKey:@"error"]) {
            NSLog(@"%@: %@", [profilesDict valueForKey:@"error"], [profilesDict valueForKey:@"error_description"]);
            return;
        }
        
        [self.profile setDatos:profilesDict];
        
        dispatch_async(dispatch_get_main_queue(), ^{
            // Els canvis visuals nomes es poden fer en la cua principal.
            [self mostrarDatosUsuario];
            [[UIApplication sharedApplication] setNetworkActivityIndicatorVisible:NO];
        });
    });
}

- (void)mostrarDatosUsuario
{
    //    NSLog(@"User: %@", self.user.username);
    self.appId.text   = self.profile.appId;
    self.app.text   = self.profile.app;
    self.Id.text   = self.profile.ident;
    self.userSubtypeId.text   = self.profile.userSubtypeId;
    self.userType.text   = self.profile.userType;
    self.usertypeId.text   = self.profile.usertypeId;
    self.userSubtype.text   = self.profile.userSubtype;
    self.language.text   = self.profile.language;

}

@end
