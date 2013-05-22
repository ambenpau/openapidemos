//
//  ViewController.m
//  openApi
//
//  Created by Oscar Iglesias Lopez on 16/05/13.
//  Copyright (c) 2013 Universitat Oberta de Catalunya. All rights reserved.
//

#import "ViewController.h"

#define keychainName    @"OpenApi_UOC"
#define urlToken        @"http://denver.uoc.es:8080/webapps/uocapi/oauth/token"
#define urlAuth         @"http://denver.uoc.es:8080/webapps/uocapi/oauth/authorize"
#define urlRedirect     @"openApi://denver.uoc.es:8080/webapps/uocapi/api/v1/"
#define idClient        @"EUI3WhtdZMjwOLxwFyzUcLUUXeE0ACmB6See1HWRjoCSIgGJ1If8EI8EPorzSWFRRnw1fxkOvIqkBI1d91GGKKG6nFnD35OY6VOEx4LcFLQIW3Z2jGsTaYey4bUcbR4K"
#define secretClient    @"scR6rJl1nssYW3I2gYaUslSsBKSMeMOp8EoyEuLgJ61MmQgtaTSBAgIknrqBqO4L26wMXWVkz5Z7WJtCyZ9huK33Z1JU95vqNbKRDRv0CoAa5z6WPdSBe5c75N5tRf2R"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)acceder:(UIButton *)sender {
    NSLog(@"Empezamos....");
    [self signIn];
}

#pragma mark - OAuth stuff
- (void)signOut
{
    [GTMOAuth2ViewControllerTouch removeAuthFromKeychainForName:keychainName];
}

- (GTMOAuth2Authentication *)myCustomAuth
{
    GTMOAuth2Authentication *auth;
    auth = [GTMOAuth2Authentication authenticationWithServiceProvider:@"Custom Service"
                                                             tokenURL:[NSURL URLWithString:urlToken]
                                                          redirectURI:urlRedirect
                                                             clientID:idClient
                                                         clientSecret:secretClient];
    return auth;
}

- (void)signIn
{
    [self signOut];
    
    GTMOAuth2Authentication *auth = [self myCustomAuth];
    NSLog(@"SIN Token = %@", [auth accessToken]);
    
    GTMOAuth2ViewControllerTouch *viewController;
    viewController = [[GTMOAuth2ViewControllerTouch alloc]
                      initWithAuthentication:auth
                            authorizationURL:[NSURL URLWithString:urlAuth]
                            keychainItemName:keychainName
                                    delegate:self
                            finishedSelector:@selector(viewController:finishedWithAuth:error:)];
    
    [[self navigationController] pushViewController:viewController animated:YES];
}

- (void)viewController:(GTMOAuth2ViewControllerTouch *)vc
      finishedWithAuth:(GTMOAuth2Authentication *) auth
                 error:(NSError *) error
{
    if (error != nil) {
        // Authentication failed (perhaps the user denied access, or closed the window before granting access)
        
        NSLog(@"Authentication error: %@", error);
        self.labelError.text = @"Error de autenticación";
      /*  NSData *responseData = [[error userInfo] objectForKey:@"data"]; // kGTMHTTPFetcherStatusDataKey
        
        if ([responseData length] > 0) {
            // show the body of the server's authentication failure response
            NSString *str = [[NSString alloc] initWithData:responseData encoding:NSUTF8StringEncoding] ;
            NSLog(@"%@", str);
        }
        
        auth = nil; */
    } else {
        // Sign-in succeeded
        NSLog(@"Sign-in succeeded");
        NSLog(@"user=%@ \n authorization=%@ \n expiration date=%@", auth.userAgent, auth.accessToken, auth.expirationDate);
        NSLog(@"Scope = %@", auth.scope);
        self.labelError.text = @"Access Granted";
        self.labelError.textColor = [UIColor greenColor];
        
        // Cambiamos de controlador al controller de lo que sera el menu.
        UserViewController *menuViewController = [self.storyboard instantiateViewControllerWithIdentifier:@"MenuView"];
        // Para que este pueda atacar al servidor le pasamos el objeto de autenticacion que contiene el token
        menuViewController.auth = auth;
        [self presentViewController:menuViewController animated:YES completion:nil];
    }
}

@end
