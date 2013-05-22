//
//  ViewController.h
//  openApi
//
//  Created by macoscar on 16/05/13.
//  Copyright (c) 2013 Universitat Oberta de Catalunya. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "MenuViewController.h"
#import "GTMOAuth2ViewControllerTouch.h"

@interface ViewController : UIViewController

@property (weak, nonatomic) IBOutlet UILabel *labelError;
- (IBAction)acceder:(UIButton *)sender;

@end
