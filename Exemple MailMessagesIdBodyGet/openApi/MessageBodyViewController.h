//
//  MessageBodyViewController.h
//  MailMessagesIdBodyGet
//
//  Created by UOC on 19/08/13.
//  Copyright (c) 2013 Universitat Oberta de Catalunya. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "MessageBody.h"
#import "GTMOAuth2Authentication.h"

@interface MessageBodyViewController : UIViewController

@property (nonatomic, strong) MessageBody *messagebody;
@property (nonatomic, retain) GTMOAuth2Authentication *auth;
@property (nonatomic, retain) NSString *idMessage;

@property (weak, nonatomic) IBOutlet UILabel *identifier;
@property (weak, nonatomic) IBOutlet UITextView *body;


@end
