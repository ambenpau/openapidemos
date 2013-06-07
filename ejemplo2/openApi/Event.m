//
//  Event.m
//  Ejemplo2
//
//  Created by macoscar on 29/05/13.
//  Copyright (c) 2013 Universitat Oberta de Catalunya. All rights reserved.
//

#import "Event.h"

@implementation Event

- (void) setDatos:(NSDictionary *)eventDictionary
{
    self.identifier = [eventDictionary objectForKey:@"id"];
    self.url        = [eventDictionary objectForKey:@"url"];
    self.summary    = [eventDictionary objectForKey:@"summary"];
    self.start      = [eventDictionary objectForKey:@"start"];
    self.end        = [eventDictionary objectForKey:@"end"];
}

@end